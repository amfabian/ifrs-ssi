# Codigo escrito por Felipe Pizzio, Alexandre Fabian, Mario Ibanez com base
# nos exemplos disponiveis no Web Playground para a disciplina de 
# Topicos em SSI073 - Tópicos Avançados em 2023-1

from irobot_edu_sdk.backend.bluetooth import Bluetooth
from irobot_edu_sdk.robots import event, hand_over, Color, Robot, Root, Create3
from irobot_edu_sdk.music import Note

robot = Create3(Bluetooth())

speed = 10 # define a velocidade
th = 150 # distancia entre o robo e o obstaculo 

#mapa de posições para o robo, sendo (0,0) a posicao inicial do robo
positions = [
  (100,0),
  (100,100),
  (0,100),
  (0,0)
]

b = 1

# funcao para imprimir no console a posicao do robo.
async def print_pos(robot):
  pos = await robot.get_position()
  print('🐢 (x  y  heading) = (', pos.x,  pos.y, pos.heading, ')')

async def forward(robot):
  await robot.set_lights_rgb(0, 255, 0) #verde
  await robot.set_wheel_speeds(speed, speed)
  
async def backoff(robot, c):
  await robot.set_lights_rgb(255, 64, 0) #laranja
  index = c
  await print_pos(robot)
  print('index', index)
  x = positions[c]
  await robot.navigate_to(x[0], x[1])

def front_obstacle(sensors):
  return sensors[3] > th

async def loop(robot):
  c = 0
  a = True
  while a:
    sensors = (await robot.get_ir_proximity()).sensors
    if front_obstacle(sensors):
      await robot.wait(0.3)
      await backoff(robot, c)
      c += b
      if c > 3:
          a = False
      await robot.wait(0.3)
      await forward(robot)
# codigo nao documentado no Web Playground, serve para fazer o robo ir para a dock
# para outras funcoes e' possivel procurar por ros2 topic list.      
  await robot.dock() 
  await robot.set_lights_rgb(127,0,0) #vermelho escuro
  
@event(robot.when_bumped, [True, True])
async def bumped(robot):
    print ('Bumper triggered')
    await robot.set_lights_rgb(111, 71, 127) #roxo
    await robot.wait(0.3)
    await robot.navigate_to(0,0)
    await robot.dock()
    await robot.set_lights_rgb(127,0,0) #vermelho escuro

@event(robot.when_play)
async def play(robot):
  await robot.undock()
  await forward(robot)
  await loop(robot)
 
robot.play()