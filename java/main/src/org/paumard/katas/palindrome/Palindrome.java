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

package org.paumard.katas.palindrome;

/**
 * Created by José
 */
public class Palindrome {

    public boolean isPalindrome(String input) {
        if (input.length() <= 1) {
            return true;
        } else if (input.length() == 2) {
            return input.charAt(0) == input.charAt(1);
        } else if (input.length() == 3) {
            return input.charAt(0) == input.charAt(2);
        } else {
            int increasingIndex = 0;
            int decreasingIndex = input.length() - 1;
            while (increasingIndex < decreasingIndex) {
                if (Character.toLowerCase(input.charAt(increasingIndex)) != Character.toLowerCase(input.charAt(decreasingIndex))) {
                    return false;
                }
                increasingIndex++;
                while (!Character.isLetter(input.charAt(increasingIndex))) {
                    increasingIndex++;
                }
                decreasingIndex--;
                while (!Character.isLetter(input.charAt(decreasingIndex))) {
                    decreasingIndex--;
                }
            }
            return true;
        }
    }
}
