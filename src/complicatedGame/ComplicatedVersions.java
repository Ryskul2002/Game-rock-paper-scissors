package complicatedGame;

public enum ComplicatedVersions {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public int compareMove(ComplicatedVersions versions) {
        if (this == versions) {
            return 0;
        }

        switch (this) {
            case ROCK:
                return versions == SCISSORS || versions == LIZARD ? 1 : -1;
            case PAPER:
                return versions == ROCK || versions == SPOCK ? 1 : -1;
            case SCISSORS:
                return versions == PAPER || versions == LIZARD ? 1 : -1;
            case LIZARD:
                return versions == SPOCK || versions == PAPER ? 1 : -1;
            case SPOCK:
                return versions == SCISSORS || versions == ROCK ? 1 : -1;
        }
        return 0;
    }
}
