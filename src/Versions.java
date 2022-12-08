public enum Versions {
    ROCK,
    PAPER,
    SCISSORS;

    public int compareMovement(Versions versions) {
        if (this == versions) {
            return 0;
        }

        switch (this) {
            case ROCK:
                return versions == SCISSORS ? 1 : -1;
            case PAPER:
                return versions == ROCK ? 1 : -1;
            case SCISSORS:
                return versions == PAPER ? 1 : -1;
        }
        return 0;
    }
}
