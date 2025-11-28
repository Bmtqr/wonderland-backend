package com.backend.Wonderland.utils;

import java.time.LocalDate;

public class ValidarFechas {

    public static boolean fechaDespues(LocalDate fecha) {
        return fecha != null && !fecha.isAfter(LocalDate.now());
    }

    public static boolean fechaAntes(LocalDate fecha) {
        return fecha != null && !fecha.isBefore(LocalDate.now());
    }

}