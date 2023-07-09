// Класс домашних животных
class DomesticAnimals extends Animals {
    public DomesticAnimals(String name) {
        super(name);
    }
}

// Класс Dogs
class Dogs extends DomesticAnimals {
    public Dogs(String name) {
        super(name);
        commands.add("Sit");
        commands.add("Lie down");
        commands.add("Fetch");
        commands.add("Bark");
    }
}

// Класс Cats
class Cats extends DomesticAnimals {
    public Cats(String name) {
        super(name);
        commands.add("Sit");
        commands.add("Climb trees");
        commands.add("Catch mice");
    }
}

// Класс Hamsters
class Hamsters extends DomesticAnimals {
    public Hamsters(String name) {
        super(name);
        commands.add("Run in wheel");
        commands.add("Eat seeds");
        commands.add("Jump around cage");
    }
}

