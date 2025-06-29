import os

def generate_readme(solve_dicts):
    with open("./TEMPLATE.md", "r+", encoding="utf8") as template_files:
        lines = "".join(template_files.readlines())


    progress_list = []
    progress_list.append("| 플랫폼 | 푼 문제 수 |\n")
    progress_list.append("|--------|------------|\n")
    for name, items in solve_dicts.items():
        if len(items) <= 0: continue
        progress_list.append(f"| {name} | {len(items)}개 |\n")
    lines = lines.replace("{{PROGRESS_LIST}}", "".join(progress_list))

    problem_list = []
    problem_list.append("| 플랫폼 | 이름 | 레벨 | 카테고리 | 링크 |\n")
    problem_list.append("|--------|-----------------|------|---------|---------|\n")
    for name, items in solve_dicts.items():
        for item in items:
            problem_list.append(f"| {name} | {item['name']} | {item['level']} | {item['comments']} | [문제 링크]({item['link']}) |\n")

    lines = lines.replace("{{PROBLEM_LIST}}", "".join(problem_list))

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
    if not os.path.isdir(base_dir): return []

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

    
