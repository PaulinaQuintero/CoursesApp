package models;

public class Comment {
    private String courseName;
    private Float courseRating;
    private String userName;
    private String courseComment;

    public Comment(String courseName,String userName,Float courseRating, String courseComment) {
        this.courseName = courseName;
        this.courseRating = courseRating;
        this.userName = userName;
        this.courseComment = courseComment;
        System.out.println("¡"+userName+" has añadido un nuevo comentario del curso "+courseName+" correctamente!");
    }




}
