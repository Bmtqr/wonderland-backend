package com.backend.Wonderland;

import com.backend.Wonderland.Model.*;
import com.backend.Wonderland.Service.*;
import com.backend.Wonderland.utils.CalculadorDv;
import com.backend.Wonderland.utils.VerificarRut;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

        private final ProductsService productService;
        private final PersonsService personsService;
        private final TablesService tablesService;
        private final OrdersService ordersService;
        private final OrderItemsService orderItemsService;

        private final Faker faker = new Faker();

        @Override
        public void run(String... args) throws Exception {

                if (productService.findAll().isEmpty())
                        loadProducts();
                if (personsService.findAll().isEmpty())
                        loadPersons();
                if (tablesService.findAll().isEmpty())
                        loadTables();
                if (ordersService.findAll().isEmpty())
                        loadOrders();
                if (orderItemsService.findAll().isEmpty())
                        loadOrdersAndItems();

                System.out.println("✔ FullDataLoader ejecutado correctamente.");
        }

        // ---------------------------------------------------------
        // 1) PRODUCTOS
        // ---------------------------------------------------------
        private void loadProducts() {

                List<Products> productos = List.of(

                                new Products(null, "Torta Cuadrada de Chocolate",
                                                3200,
                                                "Bizcocho de chocolate intenso elaborado con cacao puro y mantequilla natural.",
                                                "Tortas Cuadradas",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-cuadradas/cuadrada-chocolate.jpg"),

                                new Products(null, "Torta Cuadrada de Frutas",
                                                2800,
                                                "Torta esponjosa con trozos de frutas naturales, equilibrada en dulzura y aroma fresco.",
                                                "Tortas Cuadradas",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-cuadradas/cuadrada-frutas.jpg"),

                                new Products(null, "Torta Circular de Vainilla",
                                                3000,
                                                "Torta circular de vainilla con extracto natural y textura suave.",
                                                "Tortas Circulares",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-circulares/circular-vainilla.jpg"),

                                new Products(null, "Torta Circular de Manjar",
                                                3300,
                                                "Torta artesanal rellena con manjar y glaseado dorado.",
                                                "Tortas Circulares",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-circulares/circular-manjar.jpeg"),

                                new Products(null, "Mousse de Chocolate",
                                                2500,
                                                "Mousse de cacao 70% con textura aireada.",
                                                "Postres Individuales",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/postres-individuales/mousse-chocolate.jpg"),

                                new Products(null, "Tiramisú Clásico",
                                                3200,
                                                "Receta italiana con bizcocho remojado en café y crema mascarpone.",
                                                "Postres Individuales",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/postres-individuales/tiramisu.jpg"),

                                new Products(null, "Torta Sin Azúcar de Naranja",
                                                3000,
                                                "Bizcocho húmedo endulzado con stevia y jugo natural de naranja.",
                                                "Productos Sin Azúcar",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/sin-azucar/torta-naranja.jpg"),

                                new Products(null, "Cheesecake Sin Azúcar",
                                                3500,
                                                "Cheesecake sin azúcar refinada, endulzado naturalmente.",
                                                "Productos Sin Azúcar",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/sin-azucar/cheesecake.jpg"),

                                new Products(null, "Empanada de Manzana",
                                                1500,
                                                "Manzana caramelizada con canela en masa tradicional.",
                                                "Pastelería Tradicional",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tradicional/empanada-manzana.jpg"),

                                new Products(null, "Tarta de Santiago",
                                                2900,
                                                "Tarta española hecha con harina de almendra, sin gluten.",
                                                "Pastelería Tradicional",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tradicional/tarta-santiago.jpg"),

                                new Products(null, "Brownie Sin Gluten",
                                                2800,
                                                "Brownie húmedo hecho con harina de almendras.",
                                                "Productos Sin Gluten",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/sin-gluten/brownie.webp"),

                                new Products(null, "Pan Sin Gluten",
                                                1800,
                                                "Pan natural sin trigo, elaborado con harinas alternativas.",
                                                "Productos Sin Gluten",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/sin-gluten/pan.webp"),

                                new Products(null, "Torta Vegana de Chocolate",
                                                4200,
                                                "Torta vegana elaborada con cacao puro y aceite vegetal.",
                                                "Productos Veganos",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/vegano/torta-chocolate.jpg"),

                                new Products(null, "Galletas Veganas de Avena",
                                                2200,
                                                "Galletas sin ingredientes animales con avena premium.",
                                                "Productos Veganos",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/vegano/galletas-avena.jpg"),

                                new Products(null, "Torta Especial de Cumpleaños",
                                                4500,
                                                "Torta especial personalizable con decoraciones al gusto.",
                                                "Tortas Especiales",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-especiales/torta-cumpleanos.jpg"),

                                new Products(null, "Torta Especial de Boda",
                                                5000,
                                                "Porción de torta premium hecha para eventos especiales.",
                                                "Tortas Especiales",
                                                faker.number().numberBetween(50, 300),
                                                "assets/img/Catalogo/tortas-especiales/torta-boda.webp"));

                productos.forEach(productService::save);
                System.out.println("✔ Productos cargados");
        }

        // ---------------------------------------------------------
        // 2) PERSONAS
        // ---------------------------------------------------------
        private void loadPersons() {

                String[] rolesPermitidos = {
                                "Mesero", "Panadero", "Pastelero",
                                "Cajero", "Repostero", "Encargado", "Mantenimiento"
                };

                Set<Integer> rutsGenerados = new HashSet<>();
                VerificarRut validador = new VerificarRut();
                List<Persons> personasCreadas = new ArrayList<>();

                // ---- 10 PERSONAS COMPLETAS ----
                while (personasCreadas.size() < 10) {

                        int rut;
                        String rutConDv;

                        do {
                                rut = faker.number().numberBetween(10_000_000, 28_000_000);
                                String dv = CalculadorDv.obtenerDigitoVerificador(rut);
                                rutConDv = rut + "-" + dv;
                        } while (rutsGenerados.contains(rut) || !validador.esRutValido(rutConDv));

                        rutsGenerados.add(rut);

                        Persons p = new Persons();

                        String dvStr = CalculadorDv.obtenerDigitoVerificador(rut);
                        Integer dv = dvStr.equalsIgnoreCase("K") ? null : Integer.parseInt(dvStr);

                        p.setRut(rut);
                        p.setDv(dv);

                        p.setNames(faker.name().firstName() + " " + faker.name().firstName());
                        p.setLast_name(faker.name().lastName());

                        int edad = faker.number().numberBetween(18, 60);
                        p.setBirth_date(LocalDate.now()
                                        .minusYears(edad)
                                        .minusDays(faker.number().numberBetween(0, 365)));

                        p.setEmail(faker.internet().emailAddress());
                        p.setPassword(faker.internet().password(8, 16, true, true));
                        p.setPhone(Integer.parseInt(faker.number().digits(9)));

                        p.setRole(faker.options().option(rolesPermitidos));

                        personasCreadas.add(personsService.save(p));
                }

                // ---- 2 PERSONAS VACÍAS PARA PRUEBAS ----
                for (int i = 0; i < 2; i++) {

                        int rut;
                        String rutConDv;

                        do {
                                rut = faker.number().numberBetween(10_000_000, 28_000_000);
                                String dv = CalculadorDv.obtenerDigitoVerificador(rut);
                                rutConDv = rut + "-" + dv;
                        } while (rutsGenerados.contains(rut) || !validador.esRutValido(rutConDv));

                        rutsGenerados.add(rut);

                        Persons p = new Persons();

                        String dvStr = CalculadorDv.obtenerDigitoVerificador(rut);
                        Integer dv = dvStr.equalsIgnoreCase("K") ? null : Integer.parseInt(dvStr);

                        p.setRut(rut);
                        p.setDv(dv);

                        p.setNames(null);
                        p.setLast_name(null);
                        p.setEmail(null);
                        p.setPassword(null);
                        p.setPhone(null);
                        p.setBirth_date(null);

                        p.setRole("Mesero");

                        personsService.save(p);
                }

                System.out.println("✔ Personas generadas");
        }

        // ---------------------------------------------------------
        // 3) MESAS
        // ---------------------------------------------------------
        private void loadTables() {

                String[] estados = { "DISPONIBLE", "OCUPADA", "RESERVADA" };

                for (int i = 1; i <= 10; i++) {

                        Tables t = new Tables();
                        t.setTable_number(i);
                        t.setStatus(faker.options().option(estados));

                        tablesService.save(t);
                }

                System.out.println("✔ Mesas generadas");
        }

        // ---------------------------------------------------------
        // 4) ÓRDENES
        // ---------------------------------------------------------
        private void loadOrders() {

                List<Persons> personas = personsService.findAll();
                List<Tables> mesas = tablesService.findAll();

                for (int i = 0; i < 10; i++) {

                        Orders o = new Orders();

                        o.setPersons(personas.get(faker.number().numberBetween(0, personas.size())));
                        o.setTables(mesas.get(faker.number().numberBetween(0, mesas.size())));
                        o.setDate(LocalDate.now().minusDays(faker.number().numberBetween(0, 30)));

                        // Total será calculado en loadOrdersAndItems()
                        o.setTotal(0);

                        ordersService.save(o);
                }

                System.out.println("✔ Órdenes generadas");
        }

        // ---------------------------------------------------------
        // 5) ORDER ITEMS
        // ---------------------------------------------------------
        private void loadOrdersAndItems() {

                List<Orders> ordenes = ordersService.findAll();
                List<Products> productos = productService.findAll();

                for (Orders o : ordenes) {

                        int totalOrden = 0;

                        int cantidadItems = faker.number().numberBetween(1, 5);

                        for (int i = 0; i < cantidadItems; i++) {

                                Products prod = productos.get(faker.number()
                                                .numberBetween(0, productos.size()));

                                int quantity = faker.number().numberBetween(1, 5);
                                int price = prod.getPrice();

                                OrderItems item = new OrderItems();
                                item.setOrders(o);
                                item.setProducts(prod);
                                item.setQuantity(quantity);
                                item.setPrice(price);

                                orderItemsService.save(item);

                                totalOrden += price * quantity;
                        }

                        o.setTotal(totalOrden);
                        ordersService.save(o);
                }

                System.out.println("✔ OrderItems generados y totales actualizados");
        }
}
