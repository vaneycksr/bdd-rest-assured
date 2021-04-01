package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UserStepDefinition {

    // necessário criar para compartilhar os dados do json com toda a classe
    private Map<String, String> expectedUser = new HashMap<>();

    @Quando("eu faço um POST para {word} com os seguintes valores:")               // mapeia os campos do json usando o Map
    public void eu_faço_um_post_para_v3_user_com_os_seguintes_valores(String endpoint, Map<String,String> user) {

        // atribui o HashMap vazio que criei aos campos que passei na tabela de Usuario.feature
        // Agora, posso usar os valores dos atributos em qualquer parte da classe
        expectedUser = user;

        given().
                body(user).
        when().
                post(endpoint).
        then().
                statusCode(HttpStatus.SC_OK);
    }

    @Entao("quando faço um GET para {word} , o usuário criado é retornado")
    public void quando_faço_um_get_para_v3_user_eu_o_usuário_criado_é_retornado(String endpoint) {

        when().
                get(endpoint).
        then().
                statusCode(HttpStatus.SC_OK).
                body("username", is(expectedUser.get("username")));
    }



    @Quando("crio um usuário")
    public void crio_um_usuário() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("o usuário é salvo no sistema")
    public void o_usuário_é_salvo_no_sistema() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
