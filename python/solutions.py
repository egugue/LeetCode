import os
import re
from dataclasses import dataclass
from pathlib import Path
from typing import List

from dataclasses_json import dataclass_json


@dataclass
@dataclass_json
class Solution:
    problem_id: int
    path: str

    @staticmethod
    def from_file_name(name: str):
        id = name[:len(name) - 3]  # 3 means the length of extension (.py)
        s = Solution()
        s.problem_id = int(id)
        s.path = "./python/" + name
        return s


@dataclass
@dataclass_json
class Solutions:
    language: str
    solutions: List[Solution]


if __name__ == '__main__':
    absPath = os.path.abspath(__file__)
    absDir = os.path.dirname(absPath) + "/"

    p = Path(absDir)
    solutions = list(p.glob("*.py"))
    solutions = map(lambda pat: os.path.basename(str(pat)), solutions)

    pattern = re.compile("^[0-9]+\\.py")
    solutions = filter(lambda pat: pattern.fullmatch(pat), solutions)
    solutions = list(map(lambda pat: Solution.from_file_name(str(pat)), solutions))

    json = Solutions()
    json.solutions = solutions
    json.language = "Python3"
    print(json.to_json())
