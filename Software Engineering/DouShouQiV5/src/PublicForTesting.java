/*
 * file: PublicForTesting.java
 *
 * example:
 *     @PublicForTesting( shouldBe="private" )
 *     public boolean waitingForRotation = false;  ///< second move (rotation) of turn
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME )
public @interface PublicForTesting {
    String shouldBe();
}