package GhostWritingThesis;


public class Line<T extends Thesis> {
    private String content;
    private State state;
    private Thread[] writers;
    //array to store command line arguments
    public static String[] cmdargs = new String[6];
    public Line(T ghost, String title){
        content = title;
        state = State.INTRO;
        writers = new Thread[5];
        writers[0] = new Thread(() -> {
            synchronized (ghost) {
                while (state != State.INTRO) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.intro();
                state = State.SETUP;
                ghost.notifyAll();
            }
        });
        writers[1] = new Thread(() -> {
            synchronized (ghost) {
                while (state != State.SETUP) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.setup();
                state = State.EXPERIMENTS;
                ghost.notifyAll();
            }
        });
        writers[2] = new Thread(() -> {
            synchronized (ghost) {
                while (state != State.EXPERIMENTS) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.experiments();
                state = State.CONCLUSION;
                ghost.notifyAll();
            }
        });
        writers[3] = new Thread(() -> {
            synchronized (ghost) {
                while (state != State.CONCLUSION) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.conclusion();
                state = State.REFS;
                ghost.notifyAll();
            }
        });

        writers[4] = new Thread(() -> {
            synchronized (ghost) {
                while (state != State.REFS) {
                    try {
                        ghost.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                content += ghost.refs();
                state = State.FINISHED;
                ghost.notifyAll();
            }
        });

        for(int i = 0; i < 5; i++){
            writers[i].start();
        }

        if(state == State.FINISHED){
            for(int i = 0; i < 5; i++){
                writers[i].interrupt();
            }
        }
    }

    public String result(){
        return content;
    }

    public static void main(String[] args) {
        System.arraycopy(args, 0, cmdargs, 0, 6);
        Line<MyThesis> temp = new Line<>(new MyThesis(), args[0]);
        System.out.println(temp.result());
    }

    public static class MyThesis implements Thesis{
        public String intro(){
            return Line.cmdargs[1];
        }

        public String setup(){
            return Line.cmdargs[2];
        }

        public String experiments(){
            return Line.cmdargs[3];
        }

        public String conclusion(){
            return Line.cmdargs[4];
        }

        public String refs(){
            return Line.cmdargs[5];
        }
    }
}
