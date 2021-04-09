package support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // gera uma instancia de uma classe
public class User {

    // Builder.Deafault criar um usuario com esses valores por padrão.
    // Se mudar o valor quando for utilizar o User, pega o valor que esta sendo passado
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "vaneyck";
    @Builder.Default
    private String firstName = "Van Eyck";
    @Builder.Default
    private String lastName = "Rosas";
    @Builder.Default
    private String email = "van@email.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "839999999";
    @Builder.Default
    private int userStatus = 1;
}
