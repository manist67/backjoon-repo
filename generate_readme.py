import os

def generate_readme(solve_dicts):
    lines = []

    lines.append("# 📘 SQL 문제풀이 정리 레포지토리\n")
    lines.append("이 저장소는 플랫폼별 SQL 문제풀이 기록을 자동 정리합니다.\n")

    lines.append("\n## ✅ 진행 현황\n")
    lines.append("| 플랫폼 | 푼 문제 수 |\n")
    lines.append("|--------|------------|\n")
    for name, items in solve_dicts.items():
        lines.append(f"| {name} | {len(items)}개 |\n")

    lines.append("\n## 📄 문제 리스트\n")
    lines.append("| 플랫폼 | 이름 | 레벨 | 카테고리 | 링크 |\n")
    lines.append("|--------|-----------------|------|---------|---------|\n")
    for name, items in solve_dicts.items():
        for item in items:
            lines.append(f"| {name} | {item['name']} | {item['level']} | {item['comments']} | [문제 링크]({item['link']}) |\n")

    lines.append("\n_이 README는 `generate_readme.py`에 의해 자동으로 생성됩니다._\n")

    with open("README.md", "w", encoding="utf-8") as f:
        f.writelines(lines)


def get_file_info(dir):
    search_file_list = [ ".py", ".sql", ".c", ".cpp" ]
    comment_suffix = [ "--", "#", "//" ]

    for file_dir in os.scandir(dir):
        if any(search_file_ext in file_dir.name for search_file_ext in search_file_list):
            with open(file_dir, "r+", encoding="utf8") as file:
                first_line = file.readline()
                for suffix in comment_suffix:
                    if first_line.startswith(suffix):
                        return first_line.removeprefix(suffix).strip()

    return None

def get_link(base_dir, sub_dir, dir):
    return os.path.join(base_dir, sub_dir.name, dir.name)


def scan_items(base_dir):
    solved_questions = []
    for root in os.scandir(base_dir):
        for item in os.scandir(root):
            solved_questions.append({
                "level": root.name,
                "name": item.name,
                "comments": get_file_info(item),
                "link": get_link(base_dir, root, item)
            })
    return solved_questions

if __name__ == "__main__":
    solve_dicts = { }
    solve_dicts['백준'] = scan_items("./백준")
    solve_dicts['프로그래머스'] = scan_items("./프로그래머스")

    generate_readme(solve_dicts)

    