n, c = map(int, input().split())

total_area = 0
bedroom_area = 0
reduced_total_area = 0
for _ in range(n):
  area, room_type = input().split()
  area = int(area)
  total_area += area
  if room_type == "bedroom":
    bedroom_area += area
  if room_type == "balcony":
    reduced_total_area += area/2
  else:
    reduced_total_area += area
    

print(total_area)
print(bedroom_area)
print(reduced_total_area * c)