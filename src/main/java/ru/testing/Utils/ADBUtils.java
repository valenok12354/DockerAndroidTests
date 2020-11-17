package ru.testing.Utils;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ADBUtils {
    public static void main(String[] args) {
        runProcess("adb push");
    }

    private static final String[] WIN_RUNTIME = {"cmd.exe", "/C"};

    private static <T> T[] concat(T[] second) {
        T[] result = Arrays.copyOf((T[]) ADBUtils.WIN_RUNTIME, ADBUtils.WIN_RUNTIME.length + second.length);
        System.arraycopy(second, 0, result, ADBUtils.WIN_RUNTIME.length, second.length);
        return result;
    }

    @SneakyThrows
    public static void runProcess(String... command) {
        String[] allCommand = null;
        String _temp = null;
        List<String> line = new ArrayList<>();
        System.out.print("command to run: ");
        for (String s : command) {
            System.out.print(s);
        }
        System.out.print("\n");
        allCommand = concat(command);
        ProcessBuilder pb = new ProcessBuilder(allCommand);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        p.waitFor();
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((_temp = in.readLine()) != null) {
            System.out.println("temp line: " + _temp);
            line.add(_temp);
        }
        System.out.println("result after command: " + line);
    }
}
