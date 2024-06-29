package br.qziul.restful.dto;

import br.qziul.restful.model.Feature;

import java.util.ArrayList;
import java.util.List;

public class FeatureDTO {
    private String icon;
    private String description;

    public List<Feature> convertToFeature(List<FeatureDTO> featuresListDTO) {
        List<Feature> features = new ArrayList<>();
        for (FeatureDTO featureDTO : featuresListDTO) {
            features.add(new Feature(featureDTO.icon, featureDTO.description));
        }
        return features;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
