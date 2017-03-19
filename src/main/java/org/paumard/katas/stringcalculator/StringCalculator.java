/*
 * Copyright (C) 2017 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.katas.stringcalculator;

import java.util.regex.Pattern;

/**
 * Created by José
 */
public class StringCalculator {

    private static final String SEPARATOR = "[,\n]";

    public int add(String input) {

        if (isCustomSeparatorDefined(input)) {
            String separator = extractSeparator(input);
            String substring = removeSeparatorDeclaration(input);
            return add(substring, separator);
        } else {
            return add(input, SEPARATOR);
        }
    }

    private boolean isCustomSeparatorDefined(String input) {
        return input.startsWith("//");
    }

    private String removeSeparatorDeclaration(String input) {
        return input.substring(4);
    }

    private String extractSeparator(String input) {
        return input.substring(2, 3);
    }

    private int add(String input, String separator) {
        return Pattern.compile(separator).splitAsStream(input).mapToInt(Integer::parseInt).sum();
    }
}
