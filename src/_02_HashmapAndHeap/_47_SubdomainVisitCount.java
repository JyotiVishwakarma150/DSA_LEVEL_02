package _02_HashmapAndHeap;
import java.util.*;
public class _47_SubdomainVisitCount {
    // Function to calculate visit count of all subdomains
    public static ArrayList<String> subDomainVisits(String domains[]) {

        // Map to store subdomain -> total visits
        HashMap<String, Integer> map = new HashMap<>();

        // Traverse each domain entry
        for (String domain : domains) {

            // Split count and domain name
            String temp[] = domain.split(" ");
            int visitCount = Integer.parseInt(temp[0]);

            // Split domain by dot
            String words[] = temp[1].split("\\.");

            StringBuilder sb = new StringBuilder();

            // Build subdomains from right to left
            for (int idx = words.length - 1; idx >= 0; idx--) {

                // First word (like com)
                if (idx == words.length - 1) {
                    sb.append(words[idx]);
                }
                // Add remaining parts (google.com)
                else {
                    sb.insert(0, ".");
                    sb.insert(0, words[idx]);
                }

                String subDomain = sb.toString();

                // Add visit count in map
                if (map.containsKey(subDomain)) {
                    int csf = map.get(subDomain);
                    map.put(subDomain, csf + visitCount);
                } else {
                    map.put(subDomain, visitCount);
                }
            }
        }

        // Store final result
        ArrayList<String> res = new ArrayList<>();

        // Convert map data to output format
        for (String subDomain : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(subDomain));
            sb.append(" ");
            sb.append(subDomain);
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // Number of domains
        int n = scn.nextInt();
        scn.nextLine();

        String domains[] = new String[n];

        // Read domain input
        for (int i = 0; i < n; i++) {
            domains[i] = scn.nextLine();
        }

        // Print result
        System.out.println(subDomainVisits(domains));
    }
}
