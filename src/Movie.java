public class Movie implements MovieFace{

    private String name;
    private int length;
    private int year;

    public Movie(String name, int length, int year) {
        this.name = name;
        this.length = length;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }


    public int getYear() {
        return this.year;
    }

    public String getRealTime() {
        String realTime = this.getLength() / 60 + ":" + this.length % 60;
        return realTime;
    }

    @Override
    public String toString() {
       return this.getRealTime() + " " + this.getName();
    }
}
