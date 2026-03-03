import os
from huggingface_hub import InferenceClient

client = InferenceClient(api_key=os.environ["HUGGINGFACEHUB_API_TOKEN"])

image_auto = client.text_to_image(
    prompt="Astronaut riding a horse",
    model="black-forest-labs/FLUX.1-schnell"
)
print(image_auto)