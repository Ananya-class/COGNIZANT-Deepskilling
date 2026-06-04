
interface Playable {

    void play();
}

class Guitar implements Playable {

    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {

    public void play() {
        System.out.println("Playing Piano");
    }
}

class InterfaceDemo {

    public static void main(String[] args) {
        new Guitar().play();
        new Piano().play();
    }
}
