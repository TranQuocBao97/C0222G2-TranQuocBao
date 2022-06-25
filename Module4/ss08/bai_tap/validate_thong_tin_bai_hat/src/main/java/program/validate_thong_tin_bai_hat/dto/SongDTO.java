package program.validate_thong_tin_bai_hat.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {

    private Integer id;

    @NotBlank(message = "Không được để trống hay có kí tự trống trước sau")
    @Size(max = 800, message = "Không được vượt quá 800 từ")
    @Pattern(regexp = "[A-Za-z0-9\\s]+" ,message = "không kí tự đặc biệt")
    private String name;

    @NotBlank(message = "Không được để trống hay có kí tự trống trước sau")
    @Size(max = 300, message = "Không được vượt quá 300 từ")
    @Pattern(regexp = "[A-Za-z0-9\\s]+",message = "không kí tự đặc biệt")
    private String singer;

    @NotBlank(message = "Không được để trống hay có kí tự trống trước sau")
    @Size(max = 1000, message = "Không được vượt quá 1000 từ")
    @Pattern(regexp = "[A-Za-z0-9,\\s]+",message = "không kí tự đặc biệt")
    private String type;

    public SongDTO() {
    }

    public SongDTO(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public SongDTO(Integer id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
