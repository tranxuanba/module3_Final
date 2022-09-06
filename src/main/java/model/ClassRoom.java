package model;

public class ClassRoom {
    private int classId;
    private String classRoom;

    public ClassRoom() {
    }

    public ClassRoom(int classId, String classRoom) {
        this.classId = classId;
        this.classRoom = classRoom;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
