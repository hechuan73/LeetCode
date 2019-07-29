package items;

public enum Strategy {
    FAST {
        @Override
        public void run() {
            System.out.println("Fast!");
        }
    },
    NORMAL {
        @Override
        public void run() {
            System.out.println("Normal!");
        }
    },
    SMOOTH {
        @Override
        public void run() {
            System.out.println("Smooth!");
        }
    },
    SLOW {
        @Override
        public void run() {
            System.out.println("Slow!");
        }
    };
    public abstract void run();
}
