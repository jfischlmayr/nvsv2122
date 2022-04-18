package at.thejano.util;

import at.thejano.model.*;
import at.thejano.repository.Repository;
import org.eclipse.microprofile.jwt.JsonWebToken;

public class JWTUtil {
    public static ShopUser getUser(Repository repository, JsonWebToken jwt) {
        long id = Long.parseLong(jwt.claim(JWTClaim.USER_ID.getValue()).stream().findFirst().orElse("-1").toString());
        return repository.getUserById(id);
    }
}
