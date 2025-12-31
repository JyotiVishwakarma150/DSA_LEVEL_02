package _02_HashmapAndHeap;
import java.util.*;
public class _53_EncodeAndDecodeTinyURL {
    HashMap<String,String> map=new HashMap<>();//tiny vs original
    public String encode(String longUrl){
        StringBuilder sb=new StringBuilder();// short URL banane ke liye

        sb.append((char)(Math.floor(Math.random()*100))); // random character add kiya

        while(map.containsKey(sb.toString())){
            // agar same short URL pehle se exist karta hai
            sb.append((char)(Math.floor(Math.random()*100)));
            // naya random char add karo
        }
        // short URL → long URL mapping store
        map.put(sb.toString(),longUrl);
        // short URL return
        return sb.toString();
    }
    public String decode(String shortUrl){
        // short URL se original URL nikalo
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Object banao
        _53_EncodeAndDecodeTinyURL obj =
                new _53_EncodeAndDecodeTinyURL();

        // User se long URL lo
        System.out.print("Enter Long URL: ");
        String longUrl = sc.nextLine();

        // Encode
        String shortUrl = obj.encode(longUrl);
        System.out.println("Encoded URL: " + shortUrl);

        // Decode
        String decodedUrl = obj.decode(shortUrl);
        System.out.println("Decoded URL: " + decodedUrl);

        sc.close();
    }
}
