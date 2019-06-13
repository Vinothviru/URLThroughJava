import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class ConnectToURL {

    // Variables to hold the URL object and its connection to that URL.
    private static URL URLObj;
    private static URLConnection connect;

    public static void main(String[] args) throws IOException {
        try {
        	//CookieManager cManager = new CookieManager();
            //CookieHandler.setDefault(cManager);
        	//System.out.println(CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL )) );
        	CookieManager ckman = new CookieManager();
            CookieHandler.setDefault(ckman);
        	URLObj = new URL("http://www.tiruchyayiravaisyar.in");//http://www.tiruchyayiravaisyar.in/viewprofile.php?id=TAVSM00882
            connect = (URLConnection) URLObj.openConnection(); 
            connect.setDoOutput(true);
//            connect.getContent();
//            CookieStore ckStore = ckman.getCookieStore();
//            List<HttpCookie> cook = ckStore.getCookies();
//            HttpCookie finalcook = cook.get(0);
//            System.out.println(finalcook + "\n");
            //Desktop desktop=Desktop.getDesktop();
            //connect.addRequestProperty("Cookie", "puSm5KG4yobgaq-RUG8at1");
            
            
            //System.out.println("Does it?");
            //System.out.println(connect.getSession().getId());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
            writer.write("txt_log_profile_id=TAVSM00882&txt_pwd=viknesh&btn_login=Go");
            
            writer.close();
            connect.getContent();
            CookieStore ckStore = ckman.getCookieStore();
            List<HttpCookie> cook = ckStore.getCookies();
            HttpCookie finalcook = cook.get(0);
            //System.out.println(finalcook + "\n");
            
            //desktop.browse(URLObj.toURI());
            URLObj = new URL("http://www.tiruchyayiravaisyar.in/viewprofile.php?");//http://www.tiruchyayiravaisyar.in/viewprofile.php?id=TAVSM00882
            connect = (HttpURLConnection) URLObj.openConnection();
//            CookieStore ckStore = ckman.getCookieStore();
//            List<HttpCookie> cook = ckStore.getCookies();
//            int finalcook = cook.size();
//            System.out.println(finalcook);
            //connect.addRequestProperty("Cookie", "PHPSESSID=puSm5KG4yobgaq-RUG8at1");
            connect.addRequestProperty("Cookie", finalcook.toString());
            //connect.addRequestProperty("origin", "http://www.tiruchyayiravaisyar.in/index.php");
            connect.setDoOutput(true); 
            writer = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
            //writer.write("id=" + txt_log_profile_id);
            writer.close();
         // Now establish a buffered reader to read the URLConnection's input stream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            String lineRead = "";

            // Read all available lines of data from the URL and print them to screen.
            while ((lineRead = reader.readLine()) != null) {
                System.out.println(lineRead);
            }

            reader.close();
        }
        catch (MalformedURLException ex) {
            System.out.println("The URL specified was unable to be parsed or uses an invalid protocol. Please try again.");
            System.exit(1); 
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
                 
    }
}