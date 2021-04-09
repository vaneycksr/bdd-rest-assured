package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import support.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UserStepDefinition {

    private static final String CREAT_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    // necessário criar para compartilhar os dados do json com toda a classe
    private Map<String, String> expectedUser = new HashMap<>();

    private User user;

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

        // cria um usuario
        user = User.builder().build();

        given().
                body(user).
        when().
                post(CREAT_USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK);
    }

    @Entao("o usuário é salvo no sistema")
    public void o_usuário_é_salvo_no_sistema() {

        given().
                pathParam("name", user.getUsername()).
        when().
                get(USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK).
                body("username", is(user.getUsername()));
    }
}
