@Entity
public class Pracownicy {
    int id;
    String imie;
    String nazwisko;
    String jezykOjczysty;
    String jezykObcy;
    Double wynagrodzenie;
    String stanowisko;

    public Pracownicy(int id, String imie, String nazwisko, String jezykOjczysty, String jezykObcy, Double wynagrodzenie, String stanowisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.jezykOjczysty = jezykOjczysty;
        this.jezykObcy = jezykObcy;
        this.wynagrodzenie = wynagrodzenie;
        this.stanowisko = stanowisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getJezykOjczysty() {
        return jezykOjczysty;
    }

    public void setJezykOjczysty(String jezykOjczysty) {
        this.jezykOjczysty = jezykOjczysty;
    }

    public String getJezykObcy() {
        return jezykObcy;
    }

    public void setJezykObcy(String jezykObcy) {
        this.jezykObcy = jezykObcy;
    }

    public Double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(Double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
}
