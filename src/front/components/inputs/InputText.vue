<template>
    <div class="form__group field mb-3">
        <input 
          :id="id"
          :type="type" 
          :name="value" 
          :disabled="disabled"
          :value="modelValue"
          @input="$emit('update:modelValue', $event.target.value)"
          class="form__field py-2" 
          placeholder="&nbsp;" 
          required 
        >
        <hr class="linha-horizontal">
        <label :for="value" class="form__label">
          {{ value  }}
        </label>
    </div>
</template>

<script setup>
    defineProps({
        id: {
          type: String,
          default: ''
        },
        value: {
            type: String,
            required: true
        },
        type: {
            type: String,
            default: 'text'
        },
        disabled: {
            type: Boolean,
            default: false
        },
        modelValue: {
            type: String,
            default: ''
        }
    });
</script>

<style scoped>

.linha-horizontal {
  width: 100%;
  height: 2px;
  border-radius: 10px;
  border: none;
  background: linear-gradient(90deg, transparent, #bbb5 90%, transparent);
  background-size: 200%;
  animation: move-background 3s linear infinite;
  opacity: 1;
  transition: all 0.5s ease-in-out;
}

.form__group input:focus+.linha-horizontal {
  background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
  background-size: 200%;
  animation: move-background 3s linear infinite;
}

.form__field,
.form__field:focus~.form__label,
.form__label {
  transition: all 0.5s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

.form__group {
  position: relative;
  padding: 20px 0 0;
  width: 100%;
}

.form__group .linha-horizontal {
  position: absolute;
  top: 85%;
  z-index: 3;
}

.form__field {
  font-family: inherit;
  width: 100%;
  border: none;
  border-bottom: 2px solid transparent;
  outline: 0;
  font-weight: 700;
  font-size: 1rem;
  background: transparent;
  color: #fff;
  z-index: 4;
}

.form__field::placeholder {
  color: transparent;
}

.form__field:placeholder-shown~.form__label {
  font-size: 1rem;
  cursor: text;
  top: 20px;
}
.form__field:focus~.form__label {
  position: absolute;
  top: -1px;
  display: block;
  font-size: 1rem;
  width: fit-content;
  white-space: nowrap;
  background: linear-gradient(to right, #38bdf8, #4ade80, #fbbf24, #fb7185, #fbbf24, #4ade80, #38bdf8);
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-size: 200%;
  animation: move-background 3s linear infinite;
}

.form__field:required,
.form__field:invalid {
  box-shadow: none;
}

.form__label {
  position: absolute;
  top: -1px;
  display: flex;
  align-items: center;
  font-size: 1rem;
  pointer-events: none;
  background: linear-gradient(90deg, #eee 80%, #bbb5 90%, #eee);
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  width: fit-content;
  white-space: nowrap;
  background-size: 200%;
  animation: move-background 3s linear infinite;
  color: #eee;
}

</style>