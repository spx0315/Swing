package stdio.imis.model;

public class Page {
    public int[][] location=new int[500][500];
    public Page() {
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                location[i][j] = 0;
            }
        }
    }
}
