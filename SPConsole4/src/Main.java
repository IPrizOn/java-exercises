public class Main {
    public static void main(String[] args) throws Exception {
         Cinema cinema = new Cinema("Киномир");

         cinema.addSession("Аватар 2", "18:00");
         cinema.addSession("Человек-паук: Нет пути домой", "20:30");
 
         System.out.println(cinema);
    }
}
