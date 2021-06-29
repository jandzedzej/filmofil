package pl.filmofil.model;

public enum MovieGenre {
   DRAMA("Dramat"), PSYCHOLOGICAL("Psychologiczny"), COMEDY("Komedia"),
    WESTERN("Western"), ADVENTURE("Przygodowy"), BIOGRAPHICAL("Biograficzny");

    private String description;

    MovieGenre(String description) {
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
