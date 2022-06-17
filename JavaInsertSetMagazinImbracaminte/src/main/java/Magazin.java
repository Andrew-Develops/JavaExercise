public class Magazin {

    private String articole;
    private String marca;
    private String culoare;
    private int marime;
    private int pret;
    private String discount;

    public Magazin(String articole, String marca, String culoare, int marime, int pret, String discout) {
        this.articole = articole;
        this.marca = marca;
        this.culoare = culoare;
        this.marime = marime;
        this.pret = pret;
        this.discount = discout;
    }

    public Magazin() {
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getArticole() {
        return articole;
    }

    public void setArticole(String articole) {
        this.articole = articole;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getMarime() {
        return marime;
    }

    public void setMarime(int marime) {
        this.marime = marime;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "articole='" + articole + '\'' +
                ", marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", marime=" + marime +
                ", pret=" + pret +
                ", discout='" + discount + '\'' +
                '}';
    }
}
