// Классы вьючных животных
class DraughtAnimals extends Animals {
    public DraughtAnimals(String name) {
        super(name);
    }
}

// Класс Horses
class Horses extends DraughtAnimals {
    public Horses(String name) {
        super(name);
        commands.add("Go forward");
        commands.add("Stop");
        commands.add("Roll over");
        commands.add("Jump");
    }
}

// Класс Camels
class Camels extends DraughtAnimals {
    public Camels(String name) {
        super(name);
        commands.add("Go long distances");
        commands.add("Sit down");
        commands.add("Store water supply");
        commands.add("Carry loads");
    }
}

// Класс Donkeys
class Donkeys extends DraughtAnimals {
    public Donkeys(String name) {
        super(name);
        commands.add("Walk slowly");
        commands.add("Carry loads");
        commands.add("Bray");
    }
}
