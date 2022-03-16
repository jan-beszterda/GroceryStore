import model.*;
import utilities.Dialogs;
import utilities.ShopInitializer;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class Main {

  /*Din butik kan köras från Main-klassen. I din butik så kommer det att komma in kunder som vill handla olika typer av varor.

  Skapa upp några olika varor Tänk på arv, vad har varorna gemensamt? Vad är specifikt för de enskilda varorna?

  Skapa upp minst 2 olika personer (anställd och kund)Vad har personerna gemensamt och vad skiljer dem åt?

  Skapa upp en inköpslista som bara kunder kan ha Vad händer om varan inte finns i butiken?

  En av kunderna vill köpa energidricka som har åldersgräns - lägg till det. Var ska åldersgränsen finnas? Vilken klass ansvarar för den informationen?

  En av kunderna vill köpa snus som har en annan åldersgräns - lägg till. Återigen, var ska åldersgränsen specificeras?

  Skapa upp ett kvitto som är baserat på om varan fanns eller inte Om kunden inte fick allting på sin inköpslista så ska det alltså inte finnas med på kvittot. Vad kan ett kvitto innehålla?*/

  public static void main(String[] args) {
    new App();
  }
}
