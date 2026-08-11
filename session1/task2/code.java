int mid = len / 2;

            int[] leftCounts = new int[26];
            int[] rightCounts = new int[26];

            for (int i = 0; i < mid; i++) {
                leftCounts[s.charAt(i) - 'a']++;
            }

            int rightStart = (len % 2 == 0) ? mid : mid + 1;
            for (int i = rightStart; i < len; i++) {
                rightCounts[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(leftCounts, rightCounts)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
