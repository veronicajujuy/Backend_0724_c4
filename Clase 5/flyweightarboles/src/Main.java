import impl.ArbolFactory;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            ArbolFactory.getArbol("Frutales", 500, 300, "rojo");
            ArbolFactory.getArbol("Ornamentales", 200, 400, "verde");
        }

        Runtime runtime = Runtime.getRuntime();
        long memoryUsed = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        System.out.println("Memoria usada: " + memoryUsed + " MB");
    }
}
