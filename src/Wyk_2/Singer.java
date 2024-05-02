package Wyk_2;

public abstract class Singer {
    private static int nextId = 1; // Statyczne pole dla automatycznego przypisywania numeru
    private String name; // Imię piosenkarza
    private int id; // Numer piosenkarza

    // Konstruktor przyjmujący imię piosenkarza i automatycznie przypisujący mu numer
    public Singer(String name) {
        this.name = name;
        this.id = nextId++;
    }

    // Abstrakcyjna metoda do zaimplementowania przez klasy dziedziczące,
    // która powinna zwracać tekst piosenki
    public abstract String sing();

    // Metoda zwracająca informacje o piosenkarzu
    public String toString() {
        return "(" + id + ") " + name + ": " + sing();
    }

    // Statyczna metoda przyjmująca tablicę obiektów Singer
    // i zwracająca tekst piosenki z największą liczbą wielkich liter
    public static String loudest(Singer[] singers) {
        String loudestSong = "";
        int maxUpperCase = 0;

        for (Singer singer : singers) {
            String song = singer.sing();
            int currentUpperCase = 0;
            for (int i = 0; i < song.length(); i++) {
                if (Character.isUpperCase(song.charAt(i))) {
                    currentUpperCase++;
                }
            }
            if (currentUpperCase > maxUpperCase) {
                maxUpperCase = currentUpperCase;
                loudestSong = song;
            }
        }

        return loudestSong;
    }
}
