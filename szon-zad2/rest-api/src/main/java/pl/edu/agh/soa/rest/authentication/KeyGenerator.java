package pl.edu.agh.soa.rest.authentication;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class KeyGenerator implements KeyGeneratorInterface {
    @Override
    public Key generateKey() {
        String keyString = "kluczkluczkluczkluczkluczklucz";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
    }
}
