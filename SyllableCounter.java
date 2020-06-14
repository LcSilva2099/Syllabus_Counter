protected static int[] countSyllables(String text) {
        String[] array = text.replaceAll("[.?!,]", "").replaceAll("\\s+", " ").split("\\pZ");
        int syllablesCount = 0;
        int polysyllables = 0;
        int wordSyllableCount;

        for (String s : array) {
            wordSyllableCount = 0;
            StringBuilder build = new StringBuilder(s);
            if (build.charAt(s.length() - 1) == 'e') {
                build.deleteCharAt(s.length() - 1);
            }

            if (build.length() < 4) {
                syllablesCount++;
            } else {
                for (int j = 0; j < build.length() - 1; j++) {
                    if (isVowel(build.charAt(j)) && isVowel(build.charAt(j + 1))) {
                        syllablesCount++;
                        wordSyllableCount++;
                        j++;
                    } else if (isVowel(build.charAt(j))) {
                        syllablesCount++;
                        wordSyllableCount++;
                    } else if (j == build.length() - 2 && isVowel(build.charAt(j + 1))) {
                        if (build.charAt(j + 1) != 'e') {
                            syllablesCount++;
                            wordSyllableCount++;
                        }
                    }
                }
            }
            if (wordSyllableCount > 2) {
                polysyllables ++;
            }
        }

        if (syllablesCount == 0) syllablesCount++;
        return new int[]{syllablesCount, polysyllables};
    }
