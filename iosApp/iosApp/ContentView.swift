import SwiftUI
import shared // Import of the BackMarket Libray

func greet() -> String {
    return Greeting().greeting() // <- Shared logic class
}

func isPasswordCorrect(password: String) -> Bool {
    return PasswordValidationUseCase() // <- Shared logic class
        .invoke(password: password)
}

func generateAlertMessage(password: String) -> String {
    var message = ConstantsKt.PASSWORD_ERROR_MESSAGE // <- Shared logic class
    if (isPasswordCorrect(password: password)) {
        message = ConstantsKt.PASSWORD_SUCCESS_MESSAGE // <- Shared logic class
    }
    return message
}

struct ContentView: View {
    @State private var password: String = ""
    @State private var showingFormAlert = false

    var body: some View {
        VStack(alignment: .center) {
            Text(greet()).multilineTextAlignment(.center).padding(.top, 80).font(.title)
            TextField("Enter your magic password", text: $password).padding(24)
            Button("Check your password") { showingFormAlert.toggle() }
            .alert(isPresented: $showingFormAlert) {
                Alert(
                    title: Text("Password"),
                    message: Text(generateAlertMessage(password: password)),
                    dismissButton: .default(Text("OK"))
                )
            }
        }.frame(minWidth: 0,
                maxWidth: .infinity,
                minHeight: 0,
                maxHeight: .infinity,
                alignment: .topLeading
        )
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
