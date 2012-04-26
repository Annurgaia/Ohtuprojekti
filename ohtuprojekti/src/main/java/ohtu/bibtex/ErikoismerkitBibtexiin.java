/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.bibtex;

import java.util.HashMap;

/**
 *
 * @author moubarik
 */
public class ErikoismerkitBibtexiin {
    private HashMap<String, String> erikoismerkit = new HashMap<String, String>();
    
    public ErikoismerkitBibtexiin(){
        erikoismerkit.put("ä", "\\\\\"{a}");
        erikoismerkit.put("ö", "\\\\\"{o}");
        erikoismerkit.put("å", "\\\\aa");
        erikoismerkit.put("Ä", "\\\\\"{A}");
        erikoismerkit.put("Ö", "\\\\\"{O}");
        erikoismerkit.put("Å", "\\\\AA");
        erikoismerkit.put("ü", "\\\\\"{u}");
        erikoismerkit.put("Ü", "\\\\\"{U}");
        erikoismerkit.put("é", "\\\\´{e}");
        erikoismerkit.put("É", "\\\\´{E}");
        erikoismerkit.put("à", "\\\\`{a}");
        erikoismerkit.put("À", "\\\\`{A}");
        erikoismerkit.put("ß", "\\\\ss");
        erikoismerkit.put("ù", "\\\\`{u}");
        erikoismerkit.put("Ù", "\\\\`{U}");
        erikoismerkit.put("ò", "\\\\`{o}");
        erikoismerkit.put("Ò", "\\\\`{O}");
        erikoismerkit.put("ì", "\\\\`{i}");
        erikoismerkit.put("Ì", "\\\\`{I}");
        erikoismerkit.put("ú", "\\\\´{u}");
        erikoismerkit.put("Ú", "\\\\´{U}");
        erikoismerkit.put("ó", "\\\\´{o}");
        erikoismerkit.put("Ó", "\\\\´{O}");
        erikoismerkit.put("í", "\\\\´{i}");
        erikoismerkit.put("Í", "\\\\´{I}");
        erikoismerkit.put("è", "\\\\`{e}");
        erikoismerkit.put("È", "\\\\`{E}");
        erikoismerkit.put("á", "\\\\´{a}");
        erikoismerkit.put("Á", "\\\\´{A}");
        erikoismerkit.put("š", "\\\\u{s}");
        erikoismerkit.put("Š", "\\\\u{S}");
        erikoismerkit.put("ô", "\\\\^{o}");
        erikoismerkit.put("Ô", "\\\\^{O}");
    }
    
    public String replaceErikoismerkit(String str){
        return null;
    }
    
}
