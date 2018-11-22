package reposts.core.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dictionary_id")
    private Dictionary dictionary;
    @OneToMany(mappedBy = "dictionary")
    private Set<Dictionary> dictionaryContent;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Set<Dictionary> getDictionaryContent() {
        return dictionaryContent;
    }

    public void setDictionaryContent(Set<Dictionary> dictionaryContent) {
        this.dictionaryContent = dictionaryContent;
    }
}
