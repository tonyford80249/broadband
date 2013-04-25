package com.cdoe.ui.form.elements;

/**
 *
 * @author Tony Ford
 */
public class SeViewableReport implements Comparable<SeViewableReport> {
  private Long id;
  private Integer sequence;
  private String name;
  private String url;

    public SeViewableReport(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    
    public String getUrl() {
        return url;
    }

    
    public void setUrl(String url) {
        this.url = url;
    }

    
    public Integer getSequence() {
        return sequence;
    }

    
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeViewableReport other = (SeViewableReport) obj;
        return true;
    }

    @Override
    public int compareTo(SeViewableReport o) {
      return this.sequence - o.sequence;
    }

        
}
