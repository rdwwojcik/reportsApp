package reposts.core.dto;

import reposts.core.entities.Dictionary;

import java.util.Set;

public class DictionaryDTO {
    private Long id;
    private String name;
    private String description;
    private Dictionary dictionary;
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
