interface Movable {
    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);
}

interface Storable {
    int getInventoryLength();

    String getInventoryItem(int index);

    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();

    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    int lastXMovement;
    int lastYMovement;

    public CommandMove(Movable entity, int x, int y) {
        this.entity = entity;
        this.xMovement = x;
        this.yMovement = y;
    }

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);

    }

    @Override
    public void undo() {

    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;

    public CommandPutItem(Storable entity, String item) {
        this.entity = entity;
        this.item = item;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}