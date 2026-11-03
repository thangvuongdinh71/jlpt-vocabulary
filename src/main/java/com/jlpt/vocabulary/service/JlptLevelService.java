package com.jlpt.vocabulary.service;

import com.jlpt.vocabulary.dto.JlptLevelExistResponse;
import com.jlpt.vocabulary.dto.JlptLevelResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class JlptLevelService {
    public JlptLevelResponse getJlptLevel(String level) {
        if ("N5".equalsIgnoreCase(level)) {
            return new JlptLevelResponse(
                    "N5",
                    "Beginner",
                    "The beginner level of JLPT",
                    800
            );
        }

        if ("N4".equalsIgnoreCase(level)) {
            return new JlptLevelResponse(
                    "N4",
                    "Elementary",
                    "The elementary level of JLPT",
                    1500
            );
        }

        if ("N3".equalsIgnoreCase(level)) {
            return new JlptLevelResponse(
                    "N3",
                    "Intermediate",
                    "The intermediate level of JLPT",
                    3750
            );
        }

        if ("N2".equalsIgnoreCase(level)) {
            return new JlptLevelResponse(
                    "N2",
                    "Upper Intermediate",
                    "The upper intermediate level of JLPT",
                    5000
            );
        }

        if ("N1".equalsIgnoreCase(level)) {
            return new JlptLevelResponse(
                    "N1",
                    "Advanced",
                    "The advanced of JLPT",
                    7000
            );
        }

        return new JlptLevelResponse(
                level.toUpperCase(),
                "Unknown level",
                "No information available",
                0
        );
    }

    public List<JlptLevelResponse> getJlptLevels() {
        List<JlptLevelResponse> jlptLevelResponseList = new ArrayList<>();
        JlptLevelResponse n5 = getJlptLevel("N5");
        JlptLevelResponse n4 = getJlptLevel("N4");
        JlptLevelResponse n3 = getJlptLevel("N3");
        JlptLevelResponse n2 = getJlptLevel("N2");
        JlptLevelResponse n1 = getJlptLevel("N1");
        jlptLevelResponseList.add(n1);
        jlptLevelResponseList.add(n2);
        jlptLevelResponseList.add(n3);
        jlptLevelResponseList.add(n4);
        jlptLevelResponseList.add(n5);
        return jlptLevelResponseList;
    }

    public JlptLevelExistResponse findExists(String level) {
        boolean exists = false;
        String[] list = {"N1","N2","N3","N4","N5"};
        for (int i = 0;i< list.length;i++) {
            if (list[i].equals(level)) {
                exists = true;
            }
        }
        return new JlptLevelExistResponse(level, exists);
    }
}
