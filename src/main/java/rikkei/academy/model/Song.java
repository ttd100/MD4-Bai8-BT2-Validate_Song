package rikkei.academy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "\\w+(\\w+)*$",message = "name not valid")
    private String name;
    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^\\w+(\\w+)*$",message = "singer not valid")
    private String singer;
    @NotBlank
    @Size(max =1000)
    @Pattern(regexp = "(\\w+(\\w+)*)+(,\\w+(\\w+)*)*",message = "category not valid")
    private String category;

    public Song() {
    }

    public Song(Long id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
