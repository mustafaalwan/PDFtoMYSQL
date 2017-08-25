/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resultsearch;

/**
 *
 * @author Sherif
 */
public class Student {

    int tarbiaEslamia;
    int loghaArabia;
    int loghaEnglizia;
    int ryadyat;
    int egtmaeyat;
    int ahyaa;
    int kmeia;
    int physia;
    String rkmEmthany;
    String name;
    int total;
    String status;

    public Student(int tarbiaEslamia, int loghaArabia, int loghaEnglizia,
            int ryadyat, int egtmaeyat, int ahyaa, int kmeia, int physia,
            String rkmEmthany, String name,int total,String status) {
        this.tarbiaEslamia = tarbiaEslamia;
        this.loghaArabia = loghaArabia;
        this.loghaEnglizia = loghaEnglizia;
        this.ryadyat = ryadyat;
        this.egtmaeyat = egtmaeyat;
        this.ahyaa = ahyaa;
        this.kmeia = kmeia;
        this.physia = physia;
        this.rkmEmthany = rkmEmthany;
        this.name = name;
        this.total = total;
        this.status = status;
    }
}
