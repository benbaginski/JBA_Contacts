class Sum {
    public static int sumOfAreas(Shape[] array) {
        int areaSum = 0;
        for (Shape s : array) {
            if (s.getClass() == Square.class)
                areaSum += ((Square) s).getSide() * ((Square) s).getSide();
            else if (s.getClass() == Rectangle.class)
                areaSum += ((Rectangle) s).getHeight() * ((Rectangle) s).getWidth();
        }
        return areaSum;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}